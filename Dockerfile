FROM ubuntu:22.04

ENV DEBIAN_FRONTEND=noninteractive
ENV TZ=Asia/Kolkata

# Install base dependencies
RUN apt-get update && apt-get install -y \
    curl \
    openjdk-17-jdk \
    postgresql \
    postgresql-contrib \
    maven \
    tzdata \
    gnupg \
    && rm -rf /var/lib/apt/lists/*

# Install Node.js 20 (required for Angular)
RUN curl -fsSL https://deb.nodesource.com/setup_20.x | bash - \
    && apt-get install -y nodejs

# Set timezone
RUN ln -fs /usr/share/zoneinfo/$TZ /etc/localtime \
    && dpkg-reconfigure --frontend noninteractive tzdata

# Setup PostgreSQL
USER postgres
RUN service postgresql start && \
    psql --command "CREATE USER appuser WITH PASSWORD 'password';" && \
    psql --command "CREATE DATABASE appdb OWNER appuser;"

USER root

WORKDIR /app

# Copy projects
COPY springboot-app ./springboot-app
COPY angular-app ./angular-app

# Build Angular
WORKDIR /app/angular-app
RUN node -v
RUN npm install
RUN npm run build

# Build Spring Boot
WORKDIR /app/springboot-app
RUN mvn clean package -DskipTests

# Start script
COPY start.sh /start.sh
RUN chmod +x /start.sh

CMD ["/start.sh"]