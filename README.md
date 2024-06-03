# WorkoutApp

## Descrição do Projeto

WorkoutApp é um aplicativo Android projetado para ajudar os usuários a gerenciar seus exercícios e treinos. Com ele, você pode registrar, visualizar, atualizar e excluir exercícios, além de criar e gerenciar diferentes treinos. O aplicativo usa Firebase Authentication para autenticação de usuários.

## Funcionalidades

- Cadastro e login de usuários
- Adição, visualização, edição e exclusão de exercícios
- Criação, visualização, edição e exclusão de treinos
- Associação de exercícios a treinos
- Interface de usuário intuitiva e responsiva

## Tecnologias Utilizadas

- Kotlin
- Android Jetpack (ViewModel, LiveData, Room)
- Firebase Authentication
- View Binding
- AndroidX Libraries

## Requisitos

- Android Studio Arctic Fox (ou superior)
- JDK 8 (ou superior)
- Conta no Firebase



## Configuração Inicial

### Passo 1: Clonar o Repositório

```sh
git clone https://github.com/usuario/workoutapp.git
cd workoutapp```

### Passo 2: Configurar o Firebase
Acesse Firebase Console.

Crie um novo projeto ou use um existente.

Adicione um novo aplicativo Android ao seu projeto Firebase:

Registre o pacote: com.example.workoutapp
Baixe o arquivo google-services.json e mova-o para o diretório app do seu projeto Android.
No console Firebase, ative a autenticação de e-mail/senha:

Vá para a seção Authentication > Sign-in method.
Ative o método de entrada Email/Password.
Passo 3: Configurar o Projeto no Android Studio
Abra o Android Studio.
Selecione "Open an existing Android Studio project".
Navegue até o diretório onde você clonou o repositório e selecione-o.
Passo 4: Configurar os Repositórios
No arquivo settings.gradle.kts, configure os repositórios:

kotlin
Copiar código
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "WorkoutApp"
include(":app")
Passo 5: Sincronizar o Projeto com o Firebase
No arquivo build.gradle.kts do módulo app, adicione as dependências do Firebase:

kotlin
Copiar código
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.workoutapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.workoutapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("com.google.firebase:firebase-auth-ktx:21.1.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

apply(plugin = "com.google.gms.google-services")
Passo 6: Executar o Projeto
Conecte um dispositivo Android ou inicie um emulador.
Clique em "Run" no Android Studio para compilar e executar o aplicativo.
Uso
Registre-se com seu e-mail e senha.
Faça login com suas credenciais.
Adicione, edite ou exclua exercícios e treinos conforme necessário.
