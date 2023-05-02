FROM --platform=linux/amd64 redis:6-alpine


RUN mkdir -p /redis

WORKDIR /redis

COPY sentinel.conf .
COPY sentinel.sh /usr/local/bin/

RUN chown redis:redis /redis/*
RUN chmod +x /usr/local/bin/sentinel.sh

EXPOSE 5003

ENTRYPOINT ["sentinel.sh"]