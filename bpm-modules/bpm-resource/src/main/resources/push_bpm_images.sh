#!/bin/bash

set -e  # 遇到错误就退出，避免后续命令盲推

images=(
  auth
  gateway
  gen
  job
  monitor
  nacos
  resource
  snailjob-server
  system
  workflow
)

echo "开始批量打标签和推送镜像..."

for name in "${images[@]}"; do
  old_image="ruoyi/ruoyi-$name:2.4.1"
  new_image="artifactory.it.starmotor.tech:8443/it-images/bpm/bpm-$name:2.4.1"
  echo "处理镜像: $old_image -> $new_image"
  docker tag "$old_image" "$new_image"
  docker push "$new_image"
done

# 处理特殊镜像 ruoyi-seata-server
old_image="ruoyi-seata-server:2.4.1"
new_image="artifactory.it.starmotor.tech:8443/it-images/bpm/bpm-seata-server:2.4.1"
echo "处理镜像: $old_image -> $new_image"
docker tag "$old_image" "$new_image"
docker push "$new_image"

echo "所有镜像推送完成！"
