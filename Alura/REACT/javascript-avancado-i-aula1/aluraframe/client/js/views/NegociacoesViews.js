class NegociacoesViews {


  constructor(elemento){
    this._elemento = elemento
  }
  _template(modelo) {
    return    `
    <table class="table table-hover table-bordered">
        <thead>
            <tr>
                <th>DATA</th>
                <th>QUANTIDADE</th>
                <th>VALOR</th>
                <th>VOLUME</th>
            </tr>
        </thead>
        
        <tbody>
        ${modelo.negociacoes.map(n => 
           `
            <tr>
              <th>${DateHelper.dataParaTexto(n.data)}</th>
              <th>${n.quantidade}</th>
              <th>${n.valor}</th>
              <th>${n.volume}</th>
            </tr>
          `
        ).join("")}
        </tbody>
        
        <tfoot>
          <td colspan="3"></td>
          <td>${modelo.negociacoes.reduce((total, n) => total+n.volume, 0.0)}</td>
        </tfoot>
    </table>
    `;
  }


  update(modelo){
    this._elemento.innerHTML = this._template(modelo)
  }
}
