# Derivando da imagem oficial do MySQL
FROM mysql:5.7
RUN chown -R mysql:root /var/lib/mysql/
# Adicionando os scripts SQL para serem executados na criação do banco
COPY ./db/ /docker-entrypoint-initdb.d/

EXPOSE 3306