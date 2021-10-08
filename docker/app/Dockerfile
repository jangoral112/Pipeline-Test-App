FROM openjdk:16-alpine3.13
WORKDIR /app
COPY . .

RUN apk --update add make
#
RUN make -f Makefile.native build

#ENTRYPOINT ["./docker/app/entrypoint.sh"]
#CMD ["run"]
CMD ["make", "-f", "Makefile.native", "run"]