// break nao influencia num bloco IF
// mas while, for, switch de boa

//continue dentro do laço for e while

//seu uso é desencorajado!!!!! EVITE AO MÁXIMO!!

const nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

for (x in nums) {
  if (x == 5) {
    break;
  }

  console.log(`${x} = ${nums[x]}`);
}

for (s in nums) {
  if (s == 5) {
    continue; //interrompe a repetição atual e joga para a próxima!
  }
  console.log(`${s} = ${nums[s]}`);
}

//continue assim como o break, não funcionam dentro de um if, entao eles irão procurar
// o switch ou for ou while mais próximo

// a unica forma de quebrar um loop externo é utilizando um rótulo
// é legal e tal, mas caiu em desuso, não utilize nunca!!!
externo: for (a in nums) {
  for (b in nums) {
    if (a == 2 && b == 3) break externo;
    console.log(`PAR ${a} e ${b}`);
  }
}
