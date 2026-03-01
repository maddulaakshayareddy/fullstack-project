import axios from "axios"
import { use, useState } from "react"
import { useNavigate } from "react-router-dom"

function Home()
{
  const nav=useNavigate()
  const name=localStorage.getItem("uname")
  const [message,setMessage]=useState("")
  const [psw,setPsw]=useState("")
  const [data,setData]=useState("")
  const [username,setUsername]=useState("")
  const [userData,setUserData]=useState("") 
  const [allData,setAllData]=useState("")
  const submitData = async ()=>
  {
      try
      {
        const res=await axios.post(`http://localhost:8080/update?password=${psw}&username=${name}`)
        console.log(res)
        alert(res.data)
        setMessage("")
        setPsw("")
      }
      catch(err)
      {
        console.log(err)

      }
  }
  const submitDelete = async ()=>
  {
      try
      {
        const res=await axios.post(`http://localhost:8080/delete?username=${name}`)
        console.log(res)
        alert(res.data)
        nav("/")
      }
      catch(err)
      {
        console.log(err)  
      }
    }
    const getData = async ()=>
    {
      try
      {
        const res=await axios.get(`http://localhost:8080/view?data=${username}`)
        console.log(res)
        setUsername("")
        setData("")
        setUserData(res.data)
      }
      catch(err)
      {

      }
    }
    const viewAll = async ()=>
    {
         const res= await axios.get("http://localhost:8080/viewAll")
         console.log(res)
         setAllData(res.data)
    }
  return(
    <>
       <h1>you are at Home...</h1>
       <button onClick={()=>{setMessage("yes")}}>update password</button><br/>
       <button onClick={submitDelete}>delete</button><br/>
       <button onClick={()=>setData("yes")}>view data</button>
       <button onClick={viewAll}>view all</button>
       {message && <input onChange={(e)=>setPsw(e.target.value)} placeholder="enter new password"/>}
       {psw && <button onClick={submitData}>update</button>}
       {data && <input onChange={(e)=>setUsername(e.target.value)} placeholder="enter username"/>}
       {username && <button onClick={getData}>get data</button>}
       {userData && 
       <> 
        <p>Username: {userData.username}</p>
        <p>Email: {userData.email}</p>
        <p>Password: {userData.password}</p>    
       </>}
        {allData && allData.map((e)=>
        <>
          <p>Username: {e.username}</p>
          <p>Email: {e.email}</p>
          <p>Password: {e.password}</p>
          <hr/>
        </>)}
       </>
  )
}
export default Home





















// import axios from "axios"
// import { useState } from "react"
// import { Link } from "react-router-dom"
// import Delete from "./Delete"

// function Home()
// {
//     const name=localStorage.getItem("uname")
//     const [details,setDetails]=useState("")
//     const vDetails = async ()=>
//     {
//       console.log("hii")
//     const res=await axios.get(`http://localhost:8080/view?data=${name}`)
//      console.log(res)
//      setDetails(res.data)

//     }
//    return(
//     <>
//         <h1>you are at Home...</h1>
//         <button onClick={vDetails}>view details</button>
//         <p>{details.username}</p>
//         <p>{details.email}</p>
//         <p>{details.password}</p>
//         <Link to="/vAll">View All</Link><br/>
//         <Link to="/del" >Delete</Link>
//         <Link to="/upd" >Update</Link>
//     </>
//    )
// }
// export default Home