<h1 align=center>Biblioteca Acadêmica</h1>
<p align=center>📘 Sistema para biblioteca acadêmica hospedado na AWS ☁️</p>
<div align=center><img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white"> <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white"> <img src="https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white">
<img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white"></div>
<img style="border-radius: 10px" src="https://github.com/itsmenicky/bibliotecaAcademica/blob/main/Image/tela-principal.png">


<p align=justify>Pensando em uma instituição acadêmica que precisa cadastrar livros e periódicos para o controle dos mesmos, foi desenvolvido um sistema CRUD para controle de livros e periódicos. O sistema foi desenvolvido em Java utilizando Spring Framework. 
  Utilizando o Spring Web MVC para o controle de requisições e o Hibernate para mapeamento dos modelos para o banco de dados.</p>

### Deploy

<p align=justify>Para a hospedagem da aplicação na nuvem, a infraestrutura foi planejada de forma que, dentro de uma VPC Multi AZ, a máquina executando nossa aplicação (EC2) ficasse dentro de uma subnet pública, nos
permitindo assim o acesso à porta 8080 da aplicação e a conexão SSH, com essa configuração sendo feita a partir de um grupo de segurança. O servidor RDS por sua vez foi colocado em uma subrede privada, permitindo conexão interna apenas com a máquina EC2, com um NAT Gateway 
para permitir o acesso da subrede privada a internet</p>

![image](https://github.com/itsmenicky/bibliotecaAcademica/assets/116317424/f9febeea-c727-4928-b70a-a8882b82a1ee)

<p align=justify>Também foi emitida uma <a href="...">estimativa</a> de custos para 1 ano da aplicação em operação.</p>

