import axios from 'axios'
import { useState } from 'react'

export const useField = (type) => {
    const [value, setValue] = useState('')

    const onChange = (event) => {
        setValue(event.target.value)
    }

    const reset = () => {
        setValue('')
    }

    return [{
        type,
        value,
        onChange,
    }, reset]
}

export const useResource = url => {
    const [resources, setResources] = useState([])

    const create = async data => {
        console.log(data)
        const newResource = await axios.post(url, data)
        const updatedResources = resources.concat(newResource.data)
        setResources(updatedResources)
    }

    const service = {
        create
    }

    return [resources, service]
}