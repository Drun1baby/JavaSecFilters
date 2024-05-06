<?php

// 允许上传的文件类型
$allowedExtensions = array("jpg", "jpeg", "png", "gif");

// 上传文件的目录
$uploadDir = "uploads/";

// 检查文件是否上传成功
if (isset($_FILES["file"])) {
    $file = $_FILES["file"];

    // 获取文件的扩展名
    $extension = pathinfo($file["name"], PATHINFO_EXTENSION);

    // 检查文件类型是否允许上传
    if (!in_array(strtolower($extension), $allowedExtensions)) {
        echo "只允许上传以下类型的文件: " . implode(", ", $allowedExtensions);
        exit;
    }

    // 检查上传文件是否为真实的图像文件
    if (getimagesize($file["tmp_name"]) === false) {
        echo "上传文件不是有效的图像文件。";
        exit;
    }

    // 生成一个唯一的文件名以避免重复
    $uniqueFileName = uniqid() . "." . $extension;

    // 移动上传的文件到目标目录
    if (move_uploaded_file($file["tmp_name"], $uploadDir . $uniqueFileName)) {
        echo "文件上传成功！";
    } else {
        echo "文件上传失败。";
    }
}

