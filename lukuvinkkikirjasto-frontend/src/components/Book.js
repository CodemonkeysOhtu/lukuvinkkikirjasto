import React from 'react';

export const Book = ({ book }) => {
    const { kirjoittaja, otsikko, isbn, tagit, related } = book;
    return (
        <>
            <p>Kirjoittaja: {kirjoittaja}</p>
            <p>Otsikko: {otsikko}</p>
            <p>Tagit: {tagit.map(tagi => <>{tagi}</>)}</p>
            <p>Related courses: {related.map(related => <p>{related}</p>)}</p>
        </>
    )

}