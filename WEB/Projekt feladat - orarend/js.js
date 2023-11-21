let orarendAdatok = {
    hetkoznap: [
      {
        nap: "Hétfő",
        orak: ["Fizika", "Irodalom", "Angol", "Informatika", "Történelem", "Kémia"]
      },
      {
        nap: "Kedd",
        orak: ["Testnevelés és Sport", "Angol", "Angol", "Informatika", "Matematika", "Történelem"]
      },
      {
        nap: "Szerda",
        orak: ["Matematika", "Testnevelés és Sport", "Angol", "Irodalom", "Magyar Nyelv és Irodalom"]
      },
      {
        nap: "Csütörtök",
        orak: ["Fizika", "Matematika", "Angol", "Informatika"]
      },
      {
        nap: "Péntek",
        orak: ["Fizika", "Történelem", "Angol", "Informatika", "Matematika", "Angol"]
      }
    ],
    hetvege: [
      {
        nap: "Szombat",
        orak: ["Történelem", "Testnevelés és Sport", "Angol", "Matematika", "Irodalom", "Informatika"]
      },
      {
        nap: "Vasárnap",
        orak: ["Matematika", "Matematika", "Informatika", "Angol"]
      }
    ]
  };
  
  function tartalomRendereles() {
    let hetkoznapNapok = document.querySelector('.napok.hetkoznap');
    let hetvegeNapok = document.querySelector('.napok.hetvege');
  
    function orakRendereles(oraLista) {
        let orakDiv = document.createElement('div');
        orakDiv.className = 'orak';
      
        let oraKezdet = 8; 
        for (let i = 0; i < oraLista.length; i++) {
          let oraDiv = document.createElement('div');
          let oraVege = oraKezdet + 1;
          oraDiv.className = 'ido-tantargy';
          oraDiv.innerHTML = `<div class="ido">${oraKezdet.toString().padStart(2, '0')}:00-${oraVege.toString().padStart(2, '0')}:45</div><div class="tantargy">${oraLista[i]}</div>`;
          orakDiv.appendChild(oraDiv);
          oraKezdet++;
      
          if (i < oraLista.length - 1) {
            orakDiv.appendChild(document.createElement('br'));
          }
        }
      
        return orakDiv;
      }
    for (let i = 0; i < orarendAdatok.hetkoznap.length; i++) {
      let napDiv = document.createElement('div');
      napDiv.className = 'nap';
  
      let napCim = document.createElement('h2');
      napCim.textContent = orarendAdatok.hetkoznap[i].nap;
      napDiv.appendChild(napCim);
  
      let orakDiv = orakRendereles(orarendAdatok.hetkoznap[i].orak);
      napDiv.appendChild(orakDiv);
  
      hetkoznapNapok.appendChild(napDiv);
    }
  
    for (let i = 0; i < orarendAdatok.hetvege.length; i++) {
      let napDiv = document.createElement('div');
      napDiv.className = 'nap';
  
      let napCim = document.createElement('h2');
      napCim.textContent = orarendAdatok.hetvege[i].nap;
      napDiv.appendChild(napCim);
  
      let orakDiv = orakRendereles(orarendAdatok.hetvege[i].orak);
      napDiv.appendChild(orakDiv);
  
      hetvegeNapok.appendChild(napDiv);
    }
  }

  function Valtofunkcio() {
    const body = document.body;
    body.classList.toggle("temavaltozas");
    let seged = document.getElementById("valtogomb");
    if (seged.value == "Fekete téma") {
      seged.value = "Fehér téma";
    } else if (seged.value == "Fehér téma") {
      seged.value = "Fekete téma";
    }
  
    blackWhiteModMentesALocalStoragebe();
  }
  
  function blackWhiteModMentesALocalStoragebe() {
    const body = document.body;
    if (body.classList.contains("temavaltozas")) {
      localStorage.setItem("sotetMod", "true");
    } else {
      localStorage.setItem("sotetMod", "false");
    }
  }
  
  function blackWhiteModBeallitasALocalStoragebol() {
    const sotetMod = localStorage.getItem("sotetMod");
    if (sotetMod === "true") {
      document.body.classList.add("temavaltozas");
      document.getElementById("valtogomb").value = "Fehér téma";
    } else {
      document.body.classList.remove("temavaltozas");
      document.getElementById("valtogomb").value = "Fekete téma";
    }
  }
  
  function init() {
    tartalomRendereles();
    blackWhiteModBeallitasALocalStoragebol();
  }

  document.addEventListener("DOMContentLoaded", function() {
    const seged = document.getElementById("fel");

    window.addEventListener("scroll", () => {
        if (window.scrollY > 300) {
            seged.style.display = "block"; 
        } else {
            seged.style.display = "none"; 
        }
    });
    seged.addEventListener("click", () => {
        window.scrollTo({
            top: 0,
            behavior: "smooth" 
        });
    });
});

  window.onload = init;