import React, { useEffect } from 'react';
import { CreateForm } from './components/CreateForm';
import { ListEntries } from './components/ListEntries';
import { useResource } from './hooks';

function App() {
  const [books, booksService] = useResource('http://localhost:3001/books');

  useEffect(() => {
    booksService.getAll();
  })

  return (
    <div>
      <h1>Lukuvinkkikirjasto</h1>
      <CreateForm booksService={booksService} />
      <ListEntries books={books} />
    </div>
  );
}

export default App;
