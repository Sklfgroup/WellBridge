-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 21 juin 2024 à 18:09
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `well-bridge`
--

-- --------------------------------------------------------

--
-- Structure de la table `dossier_medical`
--

CREATE TABLE `dossier_medical` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `details` varchar(255) DEFAULT NULL,
  `medical_info_id` bigint(20) DEFAULT NULL,
  `code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `dossier_medical_speciality`
--

CREATE TABLE `dossier_medical_speciality` (
  `dossier_medical_id` bigint(20) NOT NULL,
  `medical_speciality_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `medical_access_requests`
--

CREATE TABLE `medical_access_requests` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `status` enum('PENDING','APPROVED','DENIED') DEFAULT NULL,
  `dossier_code` varchar(255) DEFAULT NULL,
  `medecin_uuid` varchar(255) DEFAULT NULL,
  `patient_uuid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `medical_history`
--

CREATE TABLE `medical_history` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `medical_history`
--

INSERT INTO `medical_history` (`id`, `created_at`, `deleted`, `updated_at`, `uuid`, `image_url`, `name`) VALUES
(1, '2024-06-19 10:14:40.000000', b'0', '2024-06-19 10:14:40.000000', 'c88353ce-dc1a-4662-aead-e4c0430523ed', 'string', 'Medicalent');

-- --------------------------------------------------------

--
-- Structure de la table `medical_info`
--

CREATE TABLE `medical_info` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `account_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `medical_info`
--

INSERT INTO `medical_info` (`id`, `created_at`, `deleted`, `updated_at`, `uuid`, `account_id`) VALUES
(1, '2024-06-21 08:26:02.000000', b'0', '2024-06-21 08:26:02.000000', 'c66b86a3-a8bf-4183-80f8-b6bbc975296a', 11),
(2, '2024-06-21 08:29:42.000000', b'0', '2024-06-21 08:29:42.000000', 'cf490866-969a-4ffd-b725-8fa8dd1738ae', 12);

-- --------------------------------------------------------

--
-- Structure de la table `medical_info_access_request`
--

CREATE TABLE `medical_info_access_request` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `status` enum('PENDING','APPROVED','DENIED') DEFAULT NULL,
  `medecin_id` bigint(20) DEFAULT NULL,
  `medical_info_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `medical_info_access_request`
--

INSERT INTO `medical_info_access_request` (`id`, `created_at`, `deleted`, `updated_at`, `uuid`, `status`, `medecin_id`, `medical_info_id`) VALUES
(1, '2024-06-21 10:46:22.000000', b'0', '2024-06-21 10:53:44.000000', '99a0c0cc-520e-4f8b-8d8a-1af47534b91b', 'APPROVED', 10, 2);

-- --------------------------------------------------------

--
-- Structure de la table `medical_info_history`
--

CREATE TABLE `medical_info_history` (
  `medical_info_id` bigint(20) NOT NULL,
  `medical_history_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `medical_specialities`
--

CREATE TABLE `medical_specialities` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `uuid` varchar(255) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date_of_birth` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `registration_number` varchar(255) DEFAULT NULL,
  `user_role` enum('SUPERADMINISTRATOR','ADMINISTRATOR','MEDECIN','PATIENT') DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `first_usage` bit(1) NOT NULL,
  `is_not_locked` bit(1) NOT NULL,
  `blood_group` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `created_at`, `deleted`, `updated_at`, `uuid`, `adresse`, `code`, `date_of_birth`, `firstname`, `lastname`, `number`, `password`, `registration_number`, `user_role`, `username`, `active`, `first_usage`, `is_not_locked`, `blood_group`) VALUES
(5, '2024-05-30 17:07:21.000000', b'0', '2024-05-30 17:07:21.000000', '8018a7aa-e077-4831-a31d-ec55594bb77b', '123 Admin St', '001', '1970-01-01 01:00:00.000000', 'Super', 'Admin', '1234567890', '$2a$10$GCBUIH6lyj2hUQuxEgCcGOmaiF27Ra7wRpobjI7ZDkqyBF6tW41pW', 'SA001', 'SUPERADMINISTRATOR', 'superadmin', b'0', b'0', b'0', NULL),
(6, '2024-05-31 13:28:39.000000', b'0', '2024-05-31 13:28:39.000000', '9268830c-b8ed-4e9b-b26c-5776c0b7430b', '123 Admin St', '034', '1970-01-01 00:00:00.000000', 'Super', 'Admin', '1234567890', '$2a$10$KN3v6AfK7EqcZXbI0TYg3.ImYqkaNRkFH2b/ThvbCZVA2Dz6ZRhdq', 'SA001', 'SUPERADMINISTRATOR', 'franklin', b'0', b'0', b'0', NULL),
(7, '2024-06-05 11:24:25.000000', b'0', '2024-06-05 11:24:25.000000', '47bedb5a-9c2e-4824-9374-d26451f4a844', NULL, NULL, NULL, 'Admin', 'User', NULL, '$2a$10$7GlKKP79hCeVeqj7dgPS8.rPZadHCLCz9ULbTKj9g8jmqsYYVZmoC', NULL, 'ADMINISTRATOR', 'newadmin', b'1', b'1', b'0', NULL),
(8, '2024-06-05 12:03:57.000000', b'0', '2024-06-05 12:03:57.000000', 'cd7ba35f-1b22-4a90-a9ea-3927bc6d0599', NULL, NULL, NULL, 'John', 'Doe', NULL, '$2a$10$uC8qM502JwnuFSgxodxgj.fLibH.n84cyYuVOnykLzRuJf4OoLzUG', NULL, 'PATIENT', 'john.doe@example.com', b'1', b'1', b'0', NULL),
(9, '2024-06-05 12:08:02.000000', b'0', '2024-06-05 12:08:02.000000', '9509b6d6-37fa-4e07-93ef-9f6b4608e0e1', NULL, NULL, NULL, 'Dr', 'Smith', NULL, '$2a$10$aUgNw32gs3K71PuERNHaDenYhRd3isLMng8LupzaOpe634RposTdi', NULL, 'MEDECIN', 'dr.smith@example.com', b'1', b'1', b'0', NULL),
(10, '2024-06-21 08:23:02.000000', b'0', '2024-06-21 08:23:02.000000', '755525f5-5a6c-4f0c-9755-3a27942dc949', 'MENDONG', '1234', '12/03/2024', 'python', 'landry', '620209335', '$2a$10$Bj1GpZUVlmHM9t9p0OJ3sObgANsp811Wo0PuREvcuMthiM4q.qJSS', 'ZEFZEE', 'MEDECIN', 'python', b'1', b'1', b'0', NULL),
(11, '2024-06-21 08:26:02.000000', b'0', '2024-06-21 08:26:02.000000', '703eda62-dde8-437c-a7a9-fbde1249ae0a', 'SIMEYON', NULL, '12/34/2023', 'djoumessi', 'arnold', '657893343', '$2a$10$0Miyhio8efxHqVXUTT/UP.TEQg/TU23xhziKBruLUR8VkN7IAFjeW', NULL, 'PATIENT', 'djoumessi', b'1', b'1', b'0', 'A++'),
(12, '2024-06-21 08:29:42.000000', b'0', '2024-06-21 08:29:42.000000', '0bdd518b-2766-45a9-81bf-0611dacf1b13', 'Mendong', NULL, '12/34/2023', 'Velosso', 'Arnold', '657893343', '$2a$10$9AyxG0UcPiVY/zd644dNFuS2RfR.xBwUKp1bkFbIQnDpWsbwp.N5e', NULL, 'PATIENT', 'velosso', b'1', b'1', b'0', 'A++');

-- --------------------------------------------------------

--
-- Structure de la table `users_seq`
--

CREATE TABLE `users_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `users_seq`
--

INSERT INTO `users_seq` (`next_val`) VALUES
(51);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `dossier_medical`
--
ALTER TABLE `dossier_medical`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_740tvuly5o7uknu4cukiav358` (`uuid`),
  ADD UNIQUE KEY `UK_kki3iiokcb635enm37ok3klcn` (`code`),
  ADD UNIQUE KEY `UK_7k2mekk2o27119u6cabfu062h` (`medical_info_id`);

--
-- Index pour la table `dossier_medical_speciality`
--
ALTER TABLE `dossier_medical_speciality`
  ADD PRIMARY KEY (`dossier_medical_id`,`medical_speciality_id`),
  ADD KEY `FKjk7y5n640rwgddb1hu6hc6g75` (`medical_speciality_id`);

--
-- Index pour la table `medical_access_requests`
--
ALTER TABLE `medical_access_requests`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_p80g7uaqj0b3pjua9ol349kkv` (`uuid`),
  ADD KEY `FKla65bx81fvehraedoyv0plom1` (`dossier_code`),
  ADD KEY `FK4qnmli2c3jdq70rurfyfnlvj6` (`medecin_uuid`),
  ADD KEY `FKfeevrgtmqybo5ndtn30scy7ux` (`patient_uuid`);

--
-- Index pour la table `medical_history`
--
ALTER TABLE `medical_history`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_sh0yq7rtpvmth22o1t8xaofoe` (`uuid`),
  ADD UNIQUE KEY `UK_dntk34duliyff2m5h6tbud9xw` (`name`);

--
-- Index pour la table `medical_info`
--
ALTER TABLE `medical_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_gfjoxh4w0fh6bgkt3vubypfss` (`uuid`),
  ADD UNIQUE KEY `UK_ppfbtoq2btryjcenbkiylntoc` (`account_id`);

--
-- Index pour la table `medical_info_access_request`
--
ALTER TABLE `medical_info_access_request`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_1e5vm4gx10q1vguym6d5r858y` (`uuid`),
  ADD KEY `FKbrtsgup76bm7eua566ugxbt9k` (`medecin_id`),
  ADD KEY `FK4ix02ufaluujhjbjt903uf0x3` (`medical_info_id`);

--
-- Index pour la table `medical_info_history`
--
ALTER TABLE `medical_info_history`
  ADD PRIMARY KEY (`medical_info_id`,`medical_history_id`),
  ADD KEY `FK7l0chta358lp4hmyd9iy8bi6n` (`medical_history_id`);

--
-- Index pour la table `medical_specialities`
--
ALTER TABLE `medical_specialities`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_8eskvvjcxt3xt3b8bfw4rwi5c` (`uuid`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6km2m9i3vjuy36rnvkgj1l61s` (`uuid`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `dossier_medical`
--
ALTER TABLE `dossier_medical`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `medical_access_requests`
--
ALTER TABLE `medical_access_requests`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `medical_history`
--
ALTER TABLE `medical_history`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `medical_info`
--
ALTER TABLE `medical_info`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `medical_info_access_request`
--
ALTER TABLE `medical_info_access_request`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `medical_specialities`
--
ALTER TABLE `medical_specialities`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `dossier_medical`
--
ALTER TABLE `dossier_medical`
  ADD CONSTRAINT `FK3sdl5fii893kftp2gba6yupq8` FOREIGN KEY (`medical_info_id`) REFERENCES `medical_info` (`id`);

--
-- Contraintes pour la table `dossier_medical_speciality`
--
ALTER TABLE `dossier_medical_speciality`
  ADD CONSTRAINT `FK6mtpdg4tl70h59yytr1t6iltv` FOREIGN KEY (`dossier_medical_id`) REFERENCES `dossier_medical` (`id`),
  ADD CONSTRAINT `FKjk7y5n640rwgddb1hu6hc6g75` FOREIGN KEY (`medical_speciality_id`) REFERENCES `medical_specialities` (`id`);

--
-- Contraintes pour la table `medical_access_requests`
--
ALTER TABLE `medical_access_requests`
  ADD CONSTRAINT `FK4qnmli2c3jdq70rurfyfnlvj6` FOREIGN KEY (`medecin_uuid`) REFERENCES `users` (`uuid`),
  ADD CONSTRAINT `FKfeevrgtmqybo5ndtn30scy7ux` FOREIGN KEY (`patient_uuid`) REFERENCES `users` (`uuid`),
  ADD CONSTRAINT `FKla65bx81fvehraedoyv0plom1` FOREIGN KEY (`dossier_code`) REFERENCES `dossier_medical` (`code`);

--
-- Contraintes pour la table `medical_info`
--
ALTER TABLE `medical_info`
  ADD CONSTRAINT `FKov6fb77tjbixpvj2jbn8hdrc7` FOREIGN KEY (`account_id`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `medical_info_access_request`
--
ALTER TABLE `medical_info_access_request`
  ADD CONSTRAINT `FK4ix02ufaluujhjbjt903uf0x3` FOREIGN KEY (`medical_info_id`) REFERENCES `medical_info` (`id`),
  ADD CONSTRAINT `FKbrtsgup76bm7eua566ugxbt9k` FOREIGN KEY (`medecin_id`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `medical_info_history`
--
ALTER TABLE `medical_info_history`
  ADD CONSTRAINT `FK7l0chta358lp4hmyd9iy8bi6n` FOREIGN KEY (`medical_history_id`) REFERENCES `medical_history` (`id`),
  ADD CONSTRAINT `FKm90sy2x3jcddu78avr0qxeb8d` FOREIGN KEY (`medical_info_id`) REFERENCES `medical_info` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
