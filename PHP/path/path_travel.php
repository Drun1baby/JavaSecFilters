<?php

$file = $_GET['file'];

$rootDirectory = '/var/www/html/';

if (strpos(realpath($file), $rootDirectory) === false) {
    echo "访问被拒绝。";
    exit;
}

