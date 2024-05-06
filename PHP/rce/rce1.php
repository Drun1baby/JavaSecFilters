<?php
if (preg_match('/system|tail|flag|exec|base64/i', $_SERVER['REQUEST_URI'])) {
    die('no!');
}

