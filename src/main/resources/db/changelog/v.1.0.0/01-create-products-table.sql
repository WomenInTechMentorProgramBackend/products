--liquibase formatted sql

--changeset taya:2
CREATE TABLE product (
                       id UUID DEFAULT gen_random_uuid() NOT NULL,
                       name VARCHAR(30) NOT NULL,
                       price VARCHAR(30) NOT NULL,
                       description VARCHAR(255) NOT NULL,
                       image_link VARCHAR(255),
                       count VARCHAR(30) NOT NULL,
                       product_code VARCHAR(30) NOT NULL,
                       created_at TIMESTAMP NOT NULL,
                       updated_at TIMESTAMP,
                       is_active SMALLINT DEFAULT 0 NOT NULL,
                       created_by VARCHAR(50) NOT NULL,
                       updated_by VARCHAR(50)
);