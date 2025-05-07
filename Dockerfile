# ベースイメージとしてOpenJDK 21を使用
FROM eclipse-temurin:21-jre-alpine

# 作業ディレクトリを作成
WORKDIR /app

# Gradleのビルド結果（JARファイル）をコンテナにコピー
COPY build/libs/*.jar app.jar

# アプリケーション起動時に実行するコマンド
ENTRYPOINT ["java", "-jar", "app.jar"]

# (必要に応じて) アプリケーションがリッスンするポートを公開
EXPOSE 8080