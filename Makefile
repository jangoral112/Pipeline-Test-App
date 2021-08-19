.Phony: image-build
 image-build:
	docker build -t test_postgres docker/

.Phony: compose
compose:
	docker-compose -p pipline_test -f docker/docker-compose.yaml up -d