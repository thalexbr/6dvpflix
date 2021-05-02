[![master Actions Status](https://github.com/thalexbr/6dvpflix/workflows/master/badge.svg)](https://github.com/thalexbr/6dvpflix/actions)


# FiapFlix
> This is a basic project with student purposes. So, a set of services is implemented with intention for provide some  endpoints for streaming movies based on netflix.

<!-- TODO: o que ele faz? breve descrição... -->

## Installation

Install JDK11:

[Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

Maven:

[Install maven](https://maven.apache.org/install.html)

Docker compose:

[Install docker](https://docs.docker.com/engine/install/)

Docker compose:

[Install docker-compose](https://docs.docker.com/compose/install)

** Ubuntu/Debian users can run the script _setup.sh_ to download all dependencies **

## Usage example

Click below to get a list of all available endpoints and how to use them

[Usage guide](assets)

## Development setup

# Build and run all project:
```sh
make install
```

# Step by step:
1. Build locally based on mvn build files

```sh
make clean
```

2. Create docker images(This step needs the step above to create .jar files)

```sh
make images
```
2. Run docker images(this step needs both of the above)

```sh
make run
```

For more type:

```sh
make help
```

## Meta

MICROSERVICES ARCHITECTURE / API / CONTAINERS

FIAP (<https://www.fiap.com.br/>)

Turma: 6DVP

Team:

```
Thales Gomes - RM337964
Edilson de Almeida - RM337240
Helton Ribeiro - RM337979
Jailson Silva - RM337212 
```

## Contributing

1. Fork it (<https://github.com/thalexbr/6dvpflix/fork>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request

<!-- Markdown link & img dfn's -->
[wiki]: https://github.com/thalexbr/6dvpflix/wiki
