FROM postgres:9.6
COPY create-multiple-postgresql-databases.sh /docker-entrypoint-initdb.d/
WORKDIR /docker-entrypoint-initdb.d/
RUN chmod a+x *.sh
