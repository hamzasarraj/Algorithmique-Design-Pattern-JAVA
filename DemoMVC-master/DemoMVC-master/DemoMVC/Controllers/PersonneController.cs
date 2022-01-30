using DemoMVC.DAO;
using DemoMVC.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Http;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;


namespace DemoMVC.Controllers
{
    public class PersonneController : Controller
    {
        public IActionResult Ajouter()
        {
            ViewBag.reponseMagique = HttpContext.Session.GetInt32("reponseALaQuestion");
            return View();
        }

        public IActionResult Liste()
        {
            List<Personne> liste = new PersonneDAO().GetAll();
            
            ViewBag.Personnes = liste;

            return View();
        }

        [HttpPost] // je spécifie que cette action correspond au post
        public IActionResult Ajouter(string txtNom, string txtPrenom)
        {
            // j'enregistre les infos dans la base....
            Personne p = new Personne();
            p.Nom = txtNom;
            p.Prenom = txtPrenom;

            PersonneDAO persDao = new PersonneDAO();
            persDao.Inserer(p);

            // rediriger vers la liste
            return RedirectToAction("Liste");

        }
    }
}
