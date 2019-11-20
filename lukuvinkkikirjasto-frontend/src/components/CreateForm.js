import React from 'react';
import { useField } from '../hooks';

export const CreateForm = ({ booksService }) => {
    const [kirjoittaja, kirjoittajaReset] = useField('text')
    const [otsikko, otsikkoReset] = useField('text')
    const [isbn, isbnReset] = useField('text')
    const [tagit, tagitReset] = useField('text')
    const [related, relatedReset] = useField('text')

    const handleSubmit = (e) => {
        e.preventDefault();

        booksService.create({
            id: Math.floor((Math.random() * 1000) + 1),
            kirjoittaja: kirjoittaja.value,
            otsikko: otsikko.value,
            isbn: isbn.value,
            tagit: tagit.value.split(','),
            related: related.value.split(',')
        })

        kirjoittajaReset();
        otsikkoReset();
        isbnReset();
        tagitReset();
        relatedReset();
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>
                kirjoittaja:
                <input {...kirjoittaja} />
            </label>

            <label>
                otsikko:
                <input {...otsikko} />
            </label>
            <label>
                isbn:
                <input {...isbn} />
            </label>
            <label>
                tagit:
                <input {...tagit} />
            </label>
            <label>
                related:
                <input {...related} />
            </label>
            <input type="submit" value="Submit" />
        </form>
    )

}