FROM anapsix/alpine-java:8_server-jre_unlimited

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

EXPOSE 80

CMD java -jar -Xms512m -Xmx512m -Xss256k -XX:SurvivorRatio=8 -XX:+UseConcMarkSweepGC -Dspring.profiles.active=docker,quartz /home/www/back-admin.jar >>/home/www/app.log 2>&1 & \
    echo "******* 查看日志..." & \
    tail -f /home/www/app.log