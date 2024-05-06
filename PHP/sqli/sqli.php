<?php

$username = $_POST['username'];
$password = $_POST['password'];

$pattern = '/^[a-zA-Z0-9]+$/'; // 仅允许字母和数字

// 检查用户名和密码是否符合预期的格式
if (!preg_match($pattern, $username) || !preg_match($pattern, $password)) {
    echo "用户名和密码只允许包含字母和数字。";
    exit;
}

