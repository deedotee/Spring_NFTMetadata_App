DROP TABLE IF EXISTS `NFTInstance`;

CREATE TABLE `nftinstance` (
		`id` BIGINT AUTO_INCREMENT,
        `name` VARCHAR(255) UNIQUE NOT NULL,
        `body` VARCHAR(255) NOT NULL,
        `size` VARCHAR(255) NOT NULL,
        `peg_count` INT NOT NULL,
        `wrap_orientation` VARCHAR(255) NOT NULL,
        PRIMARY KEY (`id`)
)