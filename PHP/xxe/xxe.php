<?php

$xmlData = file_get_contents('php://input');

libxml_disable_entity_loader(true);

$xml = simplexml_load_string($xmlData);

echo $xml->name;

