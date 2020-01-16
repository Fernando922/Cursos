import React, {useEffect, useState} from "react";
import "./global.css";
import "./app.css";
import "./Sidebar.css";
import "./Main.css";


function App() {

  const [coords, setCoords] = useState({})

  useEffect(() => {
    navigator.geolocation.getCurrentPosition(
      (position) => {

      },
      (err) => {
        console.log(err)
      },
      {
        timeout: 3000
      }
    )
  },[])

  return (
    <div id="app">
      <aside>
        <strong>Cadastar</strong>
        <form>
          <div className="input-block">
            <label htmlFor="github_username">Usuário do Github</label>
            <input name="github_username" id="github_username" required />
          </div>

          <div className="input-block">
            <label htmlFor="techs">Tecnologias</label>
            <input name="techs" id="techs" required />
          </div>

          <div className="input-group">
            <div className="input-block">
              <label htmlFor="latitude">latitude</label>
              <input name="latitude" id="latitude" required />
            </div>

            <div className="input-block">
              <label htmlFor="longitude">longitude</label>
              <input name="longitude" id="longitude" required />
            </div>
          </div>

          <button type="submit">Salvar</button>
        </form>
      </aside>
      <main>
        <ul>
          <li className="dev-item">
            <header>
              <img
                src="https://avatars2.githubusercontent.com/u/35746707?s=460&v=4"
                alt="Josiel"
              />
              <div className="user-info">
                <strong>Josiel Alves</strong>
                <span>ReactJs, React Native, Node.js</span>
              </div>
            </header>
            <p>Desenvolvedor Back end</p>
            <a href="https://google.com">Acessar perfil no github</a>
          </li>
          <li className="dev-item">
            <header>
              <img
                src="https://avatars2.githubusercontent.com/u/35746707?s=460&v=4"
                alt="Josiel"
              />
              <div className="user-info">
                <strong>Josiel Alves</strong>
                <span>ReactJs, React Native, Node.js</span>
              </div>
            </header>
            <p>Desenvolvedor Back end</p>
            <a href="https://google.com">Acessar perfil no github</a>
          </li>
          <li className="dev-item">
            <header>
              <img
                src="https://avatars2.githubusercontent.com/u/35746707?s=460&v=4"
                alt="Josiel"
              />
              <div className="user-info">
                <strong>Josiel Alves</strong>
                <span>ReactJs, React Native, Node.js</span>
              </div>
            </header>
            <p>Desenvolvedor Back end</p>
            <a href="https://google.com">Acessar perfil no github</a>
          </li>
          <li className="dev-item">
            <header>
              <img
                src="https://avatars2.githubusercontent.com/u/35746707?s=460&v=4"
                alt="Josiel"
              />
              <div className="user-info">
                <strong>Josiel Alves</strong>
                <span>ReactJs, React Native, Node.js</span>
              </div>
            </header>
            <p>Desenvolvedor Back end</p>
            <a href="https://google.com">Acessar perfil no github</a>
          </li>
          <li className="dev-item">
            <header>
              <img
                src="https://avatars2.githubusercontent.com/u/35746707?s=460&v=4"
                alt="Josiel"
              />
              <div className="user-info">
                <strong>Josiel Alves</strong>
                <span>ReactJs, React Native, Node.js</span>
              </div>
            </header>
            <p>Desenvolvedor Back end</p>
            <a href="https://google.com">Acessar perfil no github</a>
          </li>
        </ul>
      </main>
    </div>
  );
}

export default App;
