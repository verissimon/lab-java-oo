````mermaid
    classDiagram
        class NavegadorWeb {    
            +abrirPagina()
            +fecharPagina()
            +navegar()
        }

        class ReprodutorMusical {
            +tocarMusica()
            +pausarMusica()
            +avançarMusica()
            +voltarMusica()
        }

        class Telefone {
            +fazerChamada()
            +receberChamada()
            +enviarMensagem()
            +receberMensagem()
        }

        class Localizacao {
            +obterLocalizacao()
            +atualizarLocalizacao()
        }

        class AutenticacaoDoUsuario {
            +autenticar()
            +desautenticar()
        }

        class IPhone {
            -navegadorWeb: NavegadorWeb
            -reprodutorMusical: ReprodutorMusical
            -telefone: Telefone
            -localizacao: Localizacao
            -autenticacaoDoUsuario: AutenticacaoDoUsuario

            +abrirNavegadorWeb()
            +tocarMusica()
            +fazerChamada()
            +obterLocalizacao()
            +autenticar()
            +desautenticar()
        }

        NavegadorWeb -- IPhone
        ReprodutorMusical -- IPhone
        Telefone -- IPhone
        Localizacao -- IPhone
        AutenticacaoDoUsuario -- IPhone
    ```
````
