-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 13-11-2012 a las 19:10:14
-- Versión del servidor: 5.5.27
-- Versión de PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `ProyectoTwitter`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos`
--

CREATE TABLE IF NOT EXISTS `eventos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_autor` int(10) unsigned NOT NULL,
  `id_destinatario` int(10) unsigned NOT NULL,
  `id_tweet` int(10) unsigned NOT NULL,
  `tipo` tinyint(4) NOT NULL,
  `fecha` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favoritos`
--

CREATE TABLE IF NOT EXISTS `favoritos` (
  `id_usuario` int(10) unsigned NOT NULL,
  `id_tweet` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_tweet`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hashtag`
--

CREATE TABLE IF NOT EXISTS `hashtag` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `texto` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hashtagsTweets`
--

CREATE TABLE IF NOT EXISTS `hashtagsTweets` (
  `id_hashtag` int(10) unsigned NOT NULL,
  `id_tweet` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_hashtag`,`id_tweet`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensajes`
--

CREATE TABLE IF NOT EXISTS `mensajes` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_autor` int(10) unsigned NOT NULL,
  `id_destinatario` int(10) unsigned NOT NULL,
  `inReplyTo` int(10) unsigned NOT NULL,
  `texto` text COLLATE utf8_spanish2_ci NOT NULL,
  `fecha` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_autor` (`id_autor`),
  KEY `id_destinatario` (`id_destinatario`),
  KEY `fecha` (`fecha`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `places`
--

CREATE TABLE IF NOT EXISTS `places` (
  `id` int(10) unsigned NOT NULL,
  `name` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `pais` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `ciudad` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `tipo` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  `longitud1` double NOT NULL,
  `latitud1` double NOT NULL,
  `longitud2` double NOT NULL,
  `latitud2` double NOT NULL,
  `longitud3` double NOT NULL,
  `latitud3` double NOT NULL,
  `longitud4` double NOT NULL,
  `latitud4` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `retweet`
--

CREATE TABLE IF NOT EXISTS `retweet` (
  `id_usuario` int(10) unsigned NOT NULL,
  `id_tweet` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_tweet`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguidores`
--

CREATE TABLE IF NOT EXISTS `seguidores` (
  `id_seguidor` int(10) unsigned NOT NULL,
  `id_seguido` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_seguidor`,`id_seguido`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tweet`
--

CREATE TABLE IF NOT EXISTS `tweet` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `texto` varchar(140) COLLATE utf8_spanish2_ci NOT NULL,
  `autor` int(10) unsigned NOT NULL,
  `fecha` int(10) unsigned NOT NULL,
  `inReplyTo` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `autor` (`autor`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `screenName` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `password` char(40) COLLATE utf8_spanish2_ci NOT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `descripcion` varchar(60) COLLATE utf8_spanish2_ci NOT NULL,
  `Localizacion` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `profileBackgroundColor` varchar(12) COLLATE utf8_spanish2_ci NOT NULL,
  `profileBackgroundImageUrl` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `profileImageUrl` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `profileLinkColor` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `profileSidebarBorderColor` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `profileSidebarFillColor` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `profileTextColor` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `web_link` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `id_status` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `screenName`, `name`, `email`, `password`, `fecha_registro`, `descripcion`, `Localizacion`, `profileBackgroundColor`, `profileBackgroundImageUrl`, `profileImageUrl`, `profileLinkColor`, `profileSidebarBorderColor`, `profileSidebarFillColor`, `profileTextColor`, `web_link`, `id_status`) VALUES
(1, 'Antonio', 'Antonio Fernandez', 'antonio@correofalso.net', '7f4b12a90500708eb2dacde70df4124f05685048', '0000-00-00 00:00:00', '', '', '', '', '', '', '', '', '', '', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
