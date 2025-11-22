import React, { useEffect, useState } from "react";
import {Text, StyleSheet} from "react-native";

export default () => {
    const [Loading, setLoading] = useState(true)

    useEffect(() => {
        setTimeout(() => {
            setLoading(false)
        },2000)
        console.log("Ejecutando useEffect")
        setLoading(true)
    },[])

    return(
        <> 
            <Text style={styles.texto}>
                {Loading ? "Cargando app....":"Listo"}
            </Text>
        </>
    )
}

const styles = StyleSheet.create({
    texto:{
        fontSize: 48,
    },
});