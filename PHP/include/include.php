<?php

$allowedPages = array("about", "contact", "home");

$page = $_GET['page'];

if (in_array($page, $allowedPages)) {
    include($page . ".php");
} else {
    echo "无效的页面。";
}

