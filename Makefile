.Phony: compose
compose:
	docker-compose -p pipline_test -f docker/docker-compose.yaml up -d