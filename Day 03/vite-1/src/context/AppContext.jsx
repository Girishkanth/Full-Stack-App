import React, { Children, createContext, useContext, useState } from 'react'

const GlobalContext= createContext();     // Creating a global context with name "GlobalContext"
export const useGlobalContext = () => useContext(GlobalContext);      // Exporting the global contaxt using useContaxt with the name useGlobalContaxt

function AppContext({children}) {

  const [name,setName]=useState("Kathiresh");

  return (
    <GlobalContext.Provider value={{name,setName}}>
      {children}
    </GlobalContext.Provider>
  )
}

export default AppContext