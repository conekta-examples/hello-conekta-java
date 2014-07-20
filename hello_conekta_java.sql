-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 20, 2014 at 12:48 AM
-- Server version: 5.5.38
-- PHP Version: 5.3.10-1ubuntu3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hello_conekta_java`
--

-- --------------------------------------------------------

--
-- Table structure for table `charges`
--

CREATE TABLE IF NOT EXISTS `charges` (
  `id` varchar(30) NOT NULL,
  `livemode` tinyint(1) NOT NULL,
  `created_at` datetime NOT NULL,
  `status` varchar(30) NOT NULL,
  `currency` varchar(5) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `reference_id` varchar(255) DEFAULT NULL,
  `failure_code` varchar(255) DEFAULT NULL,
  `failure_message` varchar(255) DEFAULT NULL,
  `amount` int(11) NOT NULL,
  `card_name` varchar(30) DEFAULT NULL,
  `card_exp_month` varchar(2) DEFAULT NULL,
  `card_exp_year` varchar(2) DEFAULT NULL,
  `card_auth_code` varchar(6) DEFAULT NULL,
  `card_last4` varchar(4) DEFAULT NULL,
  `card_brand` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `charges`
--

INSERT INTO `charges` (`id`, `livemode`, `created_at`, `status`, `currency`, `description`, `reference_id`, `failure_code`, `failure_message`, `amount`, `card_name`, `card_exp_month`, `card_exp_year`, `card_auth_code`, `card_last4`, `card_brand`) VALUES
('53cb5220d7e1a0cca0001b0b', 0, '1970-01-17 00:30:33', 'paid', 'MXN', 'Hello java', '9839-wolf_pack', 'null', 'null', 20000, 'Jorge Lopez', '12', '19', '514623', '4242', 'visa'),
('53cb5787d7e1a04337001b8b', 0, '1970-01-17 00:30:35', 'paid', 'MXN', 'Blue jeans.', '14', 'null', 'null', 30000, 'Mauricio', '02', '17', '997385', '4242', 'visa');

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE IF NOT EXISTS `events` (
  `id` varchar(30) NOT NULL,
  `type` varchar(20) NOT NULL,
  `charge_id` varchar(30) NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `is_subscription` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `description`, `price`, `is_subscription`) VALUES
(14, 'Jeans', 'Blue jeans.', 300, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
