import React, { useState } from 'react';
import { CreateForm } from './components/CreateForm';

function App() {
  const [vinkit, setVinkit] = useState([]);
  console.log(vinkit)

  return (
    <div>
      <h1>Lukuvinkkikirjasto</h1>
      <CreateForm vinkit={vinkit} setVinkit={setVinkit} />
    </div>
  );
}

export default App;
