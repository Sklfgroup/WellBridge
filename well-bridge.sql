-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mer. 05 juin 2024 à 15:17
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

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
  `date_of_birth` datetime(6) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `registration_number` varchar(255) DEFAULT NULL,
  `user_role` enum('SUPERADMINISTRATOR','ADMINISTRATOR','MEDECIN','PATIENT') DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `first_usage` bit(1) NOT NULL,
  `is_not_locked` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `created_at`, `deleted`, `updated_at`, `uuid`, `adresse`, `code`, `date_of_birth`, `firstname`, `lastname`, `number`, `password`, `registration_number`, `user_role`, `username`, `active`, `first_usage`, `is_not_locked`) VALUES
(5, '2024-05-30 17:07:21.000000', b'0', '2024-05-30 17:07:21.000000', '8018a7aa-e077-4831-a31d-ec55594bb77b', '123 Admin St', '001', '1970-01-01 01:00:00.000000', 'Super', 'Admin', '1234567890', '$2a$10$GCBUIH6lyj2hUQuxEgCcGOmaiF27Ra7wRpobjI7ZDkqyBF6tW41pW', 'SA001', 'SUPERADMINISTRATOR', 'superadmin', b'0', b'0', b'0'),
(6, '2024-05-31 13:28:39.000000', b'0', '2024-05-31 13:28:39.000000', '9268830c-b8ed-4e9b-b26c-5776c0b7430b', '123 Admin St', '034', '1970-01-01 00:00:00.000000', 'Super', 'Admin', '1234567890', '$2a$10$KN3v6AfK7EqcZXbI0TYg3.ImYqkaNRkFH2b/ThvbCZVA2Dz6ZRhdq', 'SA001', 'SUPERADMINISTRATOR', 'franklin', b'0', b'0', b'0'),
(7, '2024-06-05 11:24:25.000000', b'0', '2024-06-05 11:24:25.000000', '47bedb5a-9c2e-4824-9374-d26451f4a844', NULL, NULL, NULL, 'Admin', 'User', NULL, '$2a$10$7GlKKP79hCeVeqj7dgPS8.rPZadHCLCz9ULbTKj9g8jmqsYYVZmoC', NULL, 'ADMINISTRATOR', 'newadmin', b'1', b'1', b'0'),
(8, '2024-06-05 12:03:57.000000', b'0', '2024-06-05 12:03:57.000000', 'cd7ba35f-1b22-4a90-a9ea-3927bc6d0599', NULL, NULL, NULL, 'John', 'Doe', NULL, '$2a$10$uC8qM502JwnuFSgxodxgj.fLibH.n84cyYuVOnykLzRuJf4OoLzUG', NULL, 'PATIENT', 'john.doe@example.com', b'1', b'1', b'0'),
(9, '2024-06-05 12:08:02.000000', b'0', '2024-06-05 12:08:02.000000', '9509b6d6-37fa-4e07-93ef-9f6b4608e0e1', NULL, NULL, NULL, 'Dr', 'Smith', NULL, '$2a$10$aUgNw32gs3K71PuERNHaDenYhRd3isLMng8LupzaOpe634RposTdi', NULL, 'MEDECIN', 'dr.smith@example.com', b'1', b'1', b'0');

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
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6km2m9i3vjuy36rnvkgj1l61s` (`uuid`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
