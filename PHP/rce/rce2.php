<?php
$str ="";
foreach ($_POST as $key => $value) {
    $str.=$key;
    $str.=$value;
}
if (preg_match("/system|tail|flag|exec|base64/i", $str)) {
    die('no!');
}