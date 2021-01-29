-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 29 jan. 2021 à 14:27
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `transfertargentapi`
--

-- --------------------------------------------------------

--
-- Structure de la table `emetteur`
--

CREATE TABLE `emetteur` (
  `id` int(11) NOT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `emetteur`
--

INSERT INTO `emetteur` (`id`, `cin`, `nom`, `prenom`, `telephone`) VALUES
(1, '123456', 'Sagna', 'Judith', '778974546'),
(2, '128456', 'Diallo', 'Aissata', '777974546');

-- --------------------------------------------------------

--
-- Structure de la table `envoi`
--

CREATE TABLE `envoi` (
  `id` int(11) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `montant` float NOT NULL,
  `emetteur_id` int(11) NOT NULL,
  `recepteur_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `envoi`
--

INSERT INTO `envoi` (`id`, `date`, `montant`, `emetteur_id`, `recepteur_id`) VALUES
(1, '29/01/2021', 100000, 1, 1),
(2, '28/01/2021', 150000, 2, 2),
(3, '29/01/2021', 100000, 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `recepteur`
--

CREATE TABLE `recepteur` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `recepteur`
--

INSERT INTO `recepteur` (`id`, `nom`, `prenom`, `telephone`) VALUES
(1, 'Fall', 'Marem', '774564565'),
(2, 'Mohamed', 'Gueye', '777564565');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `emetteur`
--
ALTER TABLE `emetteur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `envoi`
--
ALTER TABLE `envoi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5cei95saydohdlaqco11jabv7` (`emetteur_id`),
  ADD KEY `FKexc6ih4jhb67spu69v21p5m1f` (`recepteur_id`);

--
-- Index pour la table `recepteur`
--
ALTER TABLE `recepteur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `emetteur`
--
ALTER TABLE `emetteur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `envoi`
--
ALTER TABLE `envoi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `recepteur`
--
ALTER TABLE `recepteur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
