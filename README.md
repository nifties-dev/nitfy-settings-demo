# Nifty Settings Demo

This is a small SpringBoot WEB application with Nifty Settings enabled.

# HowTo
## Run on Docker
Pull and run image:
```
docker pull nifties/nifty-settings-demo:latest
docker run -p 80:8080 -p 9000:9000 --rm --name ns-demo nifties/nifty-settings-demo:latest
```
Open http://localhost in your browser.

## Build
Currently, _nifty-settings_ is not being published to any global repositories, but you can download it from
[GitHub Packages](https://github.com/nifties-dev/nifty-settings/packages/2093872).
In order to access https://maven.pkg.github.com/nifties-dev/nifty-settings repository GITHUB_USERNAME and 
GITHUB_TOKEN environment variables have to be set up as described in GitHub documentation (see
[Using a published package](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry#using-a-published-package)).

When this is done, application can be built using standard Gradle commands: 
```
./gradlew build
```

## Continuous Build & Run
```
./gradlew build --continuous
```
In separate terminal:
```
./gradlew bootRun
```
## Build and Run Using Docker 
```
docker image build nifty-settings-demo
docker run -p 80:8080 -p 9000:9000 --rm --name nifty-settings-demo nifty-settings-demo
```