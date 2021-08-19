.Phony: compose build_images build_db_image build_app_image

build_images: | build_db_image build_app_image

build_db_image:
	docker build -t test_postgres docker/db/

build_app_image:
	docker build -t test_app .

compose:
	docker-compose -p pipline_test -f docker/docker-compose.yaml up -d