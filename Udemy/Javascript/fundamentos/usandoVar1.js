{
  {
    {
      {
        {
          {
            {  //escopo
              var sera = "será??";
            }
          }
        }
      }
    }
  }
}

console.log(sera)


function teste(){  //dentro de uma função o escopo ficará restrito apenas dentro da função!
  var local = 123
  console.log(local)
}

teste()
console.log(local)  


//var pode ser ou GLOBAL ou dentro de FUNCTION