function compras(trabalho1, trabalho2) {
  const comprarSorvete = trabalho1 || trabalho2; // se o primeiro for verdadeiro, o segundo nem é lido
  const comprarTv50 = trabalho1 && trabalho2; // se o primeiro for falso, o segundo nem é lido :D
  // const comprarTv32 = !!(trabalho1 ^ trabalho2) // bitwise xor
  const comprarTv32 = trabalho1 != trabalho2; // pelo menos um dos dois será verdadeiro (nunca os dois) operador XOR
  const manterSaudavel = !comprarSorvete; // operador unario

  return {
    comprarSorvete,  // como é o mesmo nome da chave e valor, só o nome da const ja serve
    comprarTv50,
    comprarTv32,
    manterSaudavel
  };
}

console.log(compras(true, true))
console.log(compras(true, false))
console.log(compras(false, true))
console.log(compras(false, false))
