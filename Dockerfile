FROM ubuntu:22.04

# Install dependencies
RUN apt-get update && apt-get install -y \
    openjdk-17-jdk \
    nodejs \
    npm \
    postgresql \
    postgresql-contrib \
    maven \
    curl \
    && rm -rf /var/lib/apt/lists/*

# Setup PostgreSQL
USER postgres
RUN /etc/init.d/postgresql start && \
    psql --command "CREATE USER appuser WITH PASSWORD 'password';" && \
    psql --command "CREATE DATABASE appdb OWNER appuser;"

USER root

WORKDIR /app

# Copy projects
COPY springboot-app ./springboot-app
COPY angular-app ./angular-app

# Build Angular
WORKDIR /app/angular-app
RUN npm install && npm run build

# Build Spring Boot
WORKDIR /app/springboot-app
RUN mvn clean package -DskipTests

# Start script
COPY start.sh /start.sh
RUN chmod +x /start.sh

CMD ["/start.sh"]