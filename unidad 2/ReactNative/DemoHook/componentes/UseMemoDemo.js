import React, {useMemo} from "react";
import {Text, StyleSheet} from "react-native";

const users=[{name:'Juan', age:23},{name:'Elisa', age:40}]

export default () => {

    const totalAge =useMemo(()=>{
        let total=0
        console.log('Calculando la suma de las edades...')
        users.forEach(x => {
            total=total+x.age
        })
        return total
    },[users])

    return (
        <Text>{totalAge}</Text>
    )

}