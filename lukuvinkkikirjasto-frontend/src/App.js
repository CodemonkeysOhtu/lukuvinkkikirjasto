import React from 'react';
import { CreateForm } from './components/CreateForm';
import { useResource } from './hooks';

function App() {
  const [books, booksService] = useResource('http://localhost:3001/books');

  return (
    <div>
      <h1>Lukuvinkkikirjasto</h1>
      <CreateForm booksService={booksService} />
    </div>
  );
}

export default App;
