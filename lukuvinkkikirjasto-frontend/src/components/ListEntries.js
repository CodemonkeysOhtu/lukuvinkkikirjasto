import React from 'react';
import { Book } from './Book';

export const ListEntries = ({ books }) => {
    return (
        <div>
            <h2>Kirjat</h2>
            {books.map(book => <Book key={book.id} book={book} />)}
        </div>
    )
}

