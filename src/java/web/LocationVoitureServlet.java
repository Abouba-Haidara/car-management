/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.AuthentifierFacadeLocal;
import dao.ClientFacadeLocal;
import dao.ContratFacadeLocal;
import dao.FactureFacadeLocal;
import dao.LocationFacadeLocal;
import dao.PenalisationFacadeLocal;
import dao.RetourvoitureFacadeLocal;
import dao.SoustypeFacadeLocal;
import dao.TypeFacadeLocal;
import dao.VoitureFacadeLocal;
import entities.Authentifier;
import entities.Client;
import entities.Contrat;
import entities.Facture;
import entities.Location;
import entities.Penalisation;
import entities.Retourvoiture;
import entities.Soustype;
import entities.Type;
import entities.Voiture;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Timestamp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author haida
 */
@WebServlet(name = "LVS", urlPatterns = {"/location"})
public class LocationVoitureServlet extends HttpServlet {

    //inection de dependance
    @EJB
    LocationFacadeLocal locationFacadeLocal;
    @EJB
    ClientFacadeLocal clientFacadeLocal;
    @EJB
    VoitureFacadeLocal voitureFacadeLocal;
    @EJB
    AuthentifierFacadeLocal authentifierFacadeLocal;
    @EJB
    ContratFacadeLocal contratFacadeLocal;
    @EJB
    FactureFacadeLocal factureFacadeLocal;
    @EJB
    RetourvoitureFacadeLocal retourvoitureFacadeLocal;
    @EJB
    PenalisationFacadeLocal penalisationFacadeLocal;
    @EJB
    TypeFacadeLocal facadeLocal;
    @EJB 
    SoustypeFacadeLocal soustypeFacadeLocal;
    // entity
    Voiture v;
    Location l;
    Contrat c;
    Client client;
    Facture f;
    Retourvoiture rv;
    Authentifier auth;
    Penalisation p;
    HttpSession session;
    Type type;
    //helping
    List<Voiture> listsd;
//    ObjectMapper mapper1;
    String param;
    ConnexionForm cform;
    boolean vide;
    Authentifier utilisateur;
    public static final String CHEMIN = "chemin";
    public static final String ATT_FICHIER = "fichier";
    public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
    public static final String ATT_SESSION_USER = "user";
    public static final String VUE_CARBYCLIENT = "/WEB-INF/carbyclient.jsp";
    public static final String VUE_LOGIN = "/WEB-INF/login.jsp";
    public static final String VUE_REGISTER = "/WEB-INF/register.jsp";
    public static final String VUE_FORGET = "/WEB-INF/forget.jsp";
    public static final String VUE_SEARCH = "/WEB-INF/recherche.jsp";
    public static final String VUE_DASHBOARD = "/WEB-INF/dashboard.jsp";
    public static final String VUE_LOCATION = "/WEB-INF/effectuerloc.jsp";
    public static final String VUE_INDEX = "/WEB-INF/index.jsp";
    public static final String VUE_CLIENT = "/WEB-INF/ajouterclient.jsp";
    public static final String VUE_VOITURE = "/WEB-INF/ajoutervoiture.jsp";
    public static final String VUE_LISTE_CLIENT = "/WEB-INF/afficherlisteclient.jsp";
     public static final String VUE_LISTE_CONTRAT = "/WEB-INF/afficherlistecontrat.jsp";
    public static final String VUE_LISTE_VOITURE = "/WEB-INF/afficherlistevoiture.jsp";
    public static final String VUE_LISTE_LOCATIONS = "/WEB-INF/dashboard.jsp";
    public static final String VUE_LOCATIONS_EN_COURS = "/WEB-INF/loc-en-cours.jsp";
    public static final String VUE_LOCATION_PAR_DATE = "/WEB-INF/loc-par-date.jsp";
    public static final String VUE_LOCATION_RETOURNER = "/WEB-INF/retourner.jsp";
    public static final String VUE_CONTRAT = "/WEB-INF/contrat.jsp";
    private static final String FILENAME = "D:\\";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //handleRequest(request, response);
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "home":
                    request.setAttribute("voituresAv", voitureFacadeLocal.findAll());
                    request.getRequestDispatcher(VUE_INDEX).forward(request, response);
                    break;
                case "dashboard":
                    session = request.getSession();
                    if (session.getAttribute("user") == null) {
                        response.sendRedirect(request.getContextPath() + "/location?action=login");
                    } else {
                        request.setAttribute("lists", locationFacadeLocal.findAllLists());
                        request.getRequestDispatcher(VUE_DASHBOARD).forward(request, response);
                    }

                    break;
                case "client":
                    session = request.getSession();
                    if (session.getAttribute("user") == null) {
                        response.sendRedirect(request.getContextPath() + "/location?action=login");
                    } else {
                        request.setAttribute("mat", genkeytoMe(5));
                        request.getRequestDispatcher(VUE_CLIENT).forward(request, response);
                    }
                    break;
                case "listsclient":
                    session = request.getSession();
                    if (session.getAttribute("user") == null) {
                        response.sendRedirect(request.getContextPath() + "/location?action=login");
                    } else {
                        request.setAttribute("lists", clientFacadeLocal.findAll());
                        request.setAttribute("totaux", clientFacadeLocal.findAll().size());
                        request.getRequestDispatcher(VUE_LISTE_CLIENT).forward(request, response);
                    }
                  case "listscontrat":
                    session = request.getSession();
                    if (session.getAttribute("user") == null) {
                        response.sendRedirect(request.getContextPath() + "/location?action=login");
                    } else {
                        request.setAttribute("lists", contratFacadeLocal.findAll());
                       
                        request.getRequestDispatcher(VUE_LISTE_CONTRAT).forward(request, response);
                    }

                    break;
                case "listsvoiture":
                    session = request.getSession();
                    if (session.getAttribute("user") == null) {
                        response.sendRedirect(request.getContextPath() + "/location?action=login");
                    } else {
                        request.setAttribute("lists", voitureFacadeLocal.findAll());
                        request.getRequestDispatcher(VUE_LISTE_VOITURE).forward(request, response);
                    }

                    break;
                case "all-loc":
                    session = request.getSession();
                    if (session.getAttribute("user") == null) {
                        response.sendRedirect(request.getContextPath() + "/location?action=login");
                    } else {
                        request.setAttribute("lists", locationFacadeLocal.findAll());
                        request.getRequestDispatcher(VUE_LISTE_LOCATIONS).forward(request, response);
                    }

                    break;
                case "voiture":
                    session = request.getSession();
                    if (session.getAttribute("user") == null) {
                        response.sendRedirect(request.getContextPath() + "/location?action=login");
                    } else {
                        request.setAttribute("mat", genkeytoMe(5));
                        request.setAttribute("types", facadeLocal.findAll());
                        request.getRequestDispatcher(VUE_VOITURE).forward(request, response);
                    }

                    break;
                case "search":
                    session = request.getSession();
                    if (session.getAttribute("user") == null) {
                        response.sendRedirect(request.getContextPath() + "/location?action=login");
                    } else {

                        List<Location> listMoclet = locationFacadeLocal.findByMoclet(request.getParameter("moclet"));
                        request.setAttribute("results", listMoclet);
                        request.getRequestDispatcher(VUE_SEARCH).forward(request, response);
                    }
                    break;
                 case "searchcontrat":
                     
                       request.getRequestDispatcher("/WEB-INF/contrata.jsp").forward(request, response);
                    break;
                    
                case "savevoiture":
                    session = request.getSession();
                    if (session.getAttribute("user") == null) {
                        response.sendRedirect(request.getContextPath() + "/location?action=login");
                    } else {
                        v = new Voiture();
                        System.out.println(request.getParameter("modele"));
                        Type type = facadeLocal.find(Integer.parseInt(request.getParameter("type")));
                       // Soustype st = soustypeFacadeLocal.find(Integer.parseInt(request.getParameter("modele").replace("", "")));
                        v.setCouleur(request.getParameter("couleur"));
                        
                        v.setCoutparJour(Double.parseDouble(request.getParameter("coutparjour")));
                        v.setPuissance(200);
                        v.setStatutretour(1);
                        v.setMarque(request.getParameter("version"));
                        v.setModele("f");
                        v.setPhoto("default.png");
                        v.setIdtype(type);
                        v.setMatricule(request.getParameter("matricule"));
                        voitureFacadeLocal.create(v);
                        response.sendRedirect(request.getContextPath() + "/location?action=dashboard");
                    }

                    break;
                case "editcontrat":
                    session = request.getSession();
                    if (session.getAttribute("user") == null) {
                        response.sendRedirect(request.getContextPath() + "/location?action=login");
                    } else {
                        List<Retourvoiture> listsrt = retourvoitureFacadeLocal.isLocation();
                        boolean vid;
                        if (listsrt.isEmpty()) {
                            vid = true;
                        } else {
                            vid = false;
                        }
                        request.setAttribute("vid", vid);
                        request.setAttribute("lists", listsrt);
                        request.getRequestDispatcher(VUE_CONTRAT).forward(request, response);

                    }

                    break;

                case "getvoiturebyclient":
                    session = request.getSession();
                    if (session.getAttribute("user") == null) {
                        response.sendRedirect(request.getContextPath() + "/location?action=login");
                    } else {
                        request.setAttribute("mat", genkeytoMe(5));
                        request.getRequestDispatcher(VUE_CARBYCLIENT).forward(request, response);
                    }
                    break;
                case "savecontrat":
                    session = request.getSession();
                    if (session.getAttribute("user") == null) {
                        response.sendRedirect(request.getContextPath() + "/location?action=login");
                    } else {
                        c = new Contrat();
                        c.setDate(new Date());
                        System.out.println(request.getParameter("idlocation"));
                        Location l = locationFacadeLocal.find(Integer.parseInt(request.getParameter("idlocation")));
                        c.setDate(new Date());
                        c.setAgence("Raider Auto ");
                        c.setIdclient(l.getIdClient());
                        contratFacadeLocal.create(c);
                        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                                    response.sendRedirect(request.getContextPath() + "/location?action=dashboard");
                                }

                    break;
                case "login":
                    session = request.getSession(false);
                    auth = (Authentifier) session.getAttribute("user");
                    if (auth != null && action.equals("login")) {
                        response.sendRedirect(request.getContextPath() + "/location?action=dashboard");
                    } else {
                        request.getRequestDispatcher(VUE_LOGIN).forward(request, response);
                    }
                    break;
                case "register":
                    session = request.getSession(false);
                    auth = (Authentifier) session.getAttribute("user");
                    if (auth != null && action.equals("register")) {
                        response.sendRedirect(request.getContextPath() + "/location?action=dashboard");
                    } else {
                        request.getRequestDispatcher(VUE_REGISTER).forward(request, response);
                    }
                    break;
                    
             case "regiistration":
                    String n = request.getParameter("n");
                      
                      String e = request.getParameter("email");
                       String pwd = request.getParameter("password");
                        String pwdc = request.getParameter("password_confirm");
                        auth = new Authentifier();
                        auth.setEmail(e);
                        auth.setPassword(pwd);
                        auth.setLogin(n);
                        authentifierFacadeLocal.create(auth);
                    break;
              case "forget":
                    session = request.getSession(false);
                    auth = (Authentifier) session.getAttribute("user");
                    if (auth != null && action.equals("register")) {
                        response.sendRedirect(request.getContextPath() + "/location?action=dashboard");
                    } else {
                        request.getRequestDispatcher(VUE_FORGET).forward(request, response);
                    }
                    break;
                case "logged":
                    session = request.getSession();
                    utilisateur = new Authentifier();
                    utilisateur.setEmail(request.getParameter("email"));
                    utilisateur.setPassword(request.getParameter("password"));
                    utilisateur = authentifierFacadeLocal.findByEmailPassword(utilisateur);
                    if (utilisateur == null) {
                        session.setAttribute(ATT_SESSION_USER, null);
                        request.setAttribute("error", "login et / ou password incorrecte :)");
                        request.getRequestDispatcher(VUE_LOGIN).forward(request, response);
                    } else {
                        session = request.getSession();
                        session.setAttribute(ATT_SESSION_USER, utilisateur);
                        response.sendRedirect(request.getContextPath() + "/location?action=dashboard");
                    }             
                    break;
                case "logout":
                    session = request.getSession();
                    session.setAttribute("user", null);
                    session.invalidate();
                    response.sendRedirect(request.getContextPath() + "/location?action=home");
                    break;
                case "loc-en-cours":
                     session=request.getSession();        
                 if(session.getAttribute("user") == null){
                     response.sendRedirect(request.getContextPath()+"/location?action=login"); 
                 }else
                 {
                      request.setAttribute("lists", retourvoitureFacadeLocal.isLocation());
                    request.getRequestDispatcher(VUE_LOCATIONS_EN_COURS).forward(request, response); 
                 }
                  
                    break;
                case "loc-par-date":
                     session=request.getSession();        
                 if(session.getAttribute("user") == null){
                     response.sendRedirect(request.getContextPath()+"/location?action=login"); 
                 }else
                 {
                       if (request.getParameter("dd") != null && request.getParameter("df") != null) {
                        String ddt = request.getParameter("dd").replace("T", " ") + ":00";
                        String dtf = request.getParameter("df").replace("T", " ") + ":00";
                        List<Location> locations = locationFacadeLocal.searchByIntValdate(parseDate(ddt), parseDate(dtf));
                        System.out.println("je suis ici=" + locations);
                        if (locations == null) {
                            request.setAttribute("vide", true);
                        } else {
                            request.setAttribute("lists", locations);
                        }
                    }
                    request.getRequestDispatcher(VUE_LOCATION_PAR_DATE).forward(request, response);
                 }
                  
                    break;
                case "retourner":
                     session=request.getSession();        
                 if(session.getAttribute("user") == null){
                     response.sendRedirect(request.getContextPath()+"/location?action=login"); 
                 }else
                 {
                   List<Voiture> lists = voitureFacadeLocal.availables(1);
                    request.getRequestDispatcher(VUE_LOCATION_RETOURNER).forward(request, response);  
                 }
                    
                    break;
                case "listvnor":
                     session=request.getSession();        
                 if(session.getAttribute("user") == null){
                     response.sendRedirect(request.getContextPath()+"/location?action=login"); 
                 }else
                 {
                    List<Voiture> listss = voitureFacadeLocal.availables(0);
                    request.setAttribute("lists", listss);
                    request.getRequestDispatcher("/WEB-INF/listvno.jsp").forward(request, response); 
                 }
                    
                    break;
                case "effectuer":
                     session=request.getSession();        
                 if(session.getAttribute("user") == null){
                     response.sendRedirect(request.getContextPath()+"/location?action=login"); 
                 }else
                 {
                    listsd = voitureFacadeLocal.availables(1);
                    if (listsd.isEmpty()) {
                        vide = true;
                    } else {
                        vide = false;
                    }
                    request.setAttribute("vide", vide);
                    request.setAttribute("mat", genkeytoMe(5));
                    request.setAttribute("voitures", listsd);
                    request.getRequestDispatcher(VUE_LOCATION).forward(request, response);  
                 }
                   
                    break;
                case "retour":
                     session=request.getSession();        
                 if(session.getAttribute("user") == null){
                     response.sendRedirect(request.getContextPath()+"/location?action=login"); 
                 }else
                 {
                       String para = request.getParameter("param");
                    List<Retourvoiture> listsr = retourvoitureFacadeLocal.all();
                    if (para != null)
                    {
                        rv = retourvoitureFacadeLocal.find(Integer.parseInt(para));
                        Voiture v = rv.getIdLocation().getIdvoiture();
                        v.setStatutretour(1);
                        voitureFacadeLocal.edit(v);
                        rv.setIdLocation(null);
                        rv.setDateretour(new Date());
                        retourvoitureFacadeLocal.edit(rv);
                        listsr = retourvoitureFacadeLocal.all();
                        
                        
                    }
                 
                 }
                  
                    break;
                case "savelocation":
                       session=request.getSession();        
                 if(session.getAttribute("user") == null){
                     response.sendRedirect(request.getContextPath()+"/location?action=login"); 
                 }else
                 {
                    l = new Location();
                    Date dd = null;
                    Date df = null;
                    //recuperation de form
                    String matricule = request.getParameter("matricule").trim();
                    String numero = request.getParameter("numero").trim();
                    String ddt = request.getParameter("dd").trim().replace("T", " ") + ":00";
                    String dtf = request.getParameter("df").trim().replace("T", " ") + ":00";
                    dd = parseDate(ddt);
                    df = parseDate(dtf);
                    String voit = request.getParameter("v").trim();
                    double mnt = Double.parseDouble(request.getParameter("mnt").trim());
                    String typepaye = request.getParameter("typepaye").trim();
                    if (matricule.equals("") || numero.equals("") || ddt.equals("") || voit.equals("") || dtf.equals("") || mnt == 0.0 || typepaye.equals("")) {
                        listsd = voitureFacadeLocal.availables(1);
                        if (listsd.isEmpty()) {
                            vide = true;
                        } else {
                            vide = false;
                        }
                        request.setAttribute("vide", vide);
                        request.setAttribute("voitures", listsd);
                        request.setAttribute("l", null);
                        request.setAttribute("mat", genkeytoMe(5));
                        request.setAttribute("errors", "Une erreur est servenu!..veuillez remplir tout le champ!");
                        request.getRequestDispatcher(VUE_LOCATION).forward(request, response);
                    } else {
                        v = voitureFacadeLocal.find(Integer.parseInt(voit));
                        client = clientFacadeLocal.findClientByMatricule(matricule);
                        l.setDatedebut(dd);
                        l.setDateretour(df);
                        l.setMatricule(numero);
                        l.setIdvoiture(v);
                        l.setDateLocation(df);
                        l.setTypePayment(typepaye);
                        l.setDateLocation(new Date());
                        l.setHeurederetour(df);
                        l.setIdClient(client);
                       Date  dd1 = new Date();
                        if(dd1.compareTo(dd) == 1  )                      
                        {
                            listsd = voitureFacadeLocal.availables(1);
                            if (listsd.isEmpty()) {
                                vide = true;
                            } else {
                                vide = false;
                            }
                            request.setAttribute("vide", vide);
                            request.setAttribute("voitures", listsd);
                            request.setAttribute("l", l);
                            request.setAttribute("e", "Ooops une, vous ne pouvez pas effectuer une location a une date anteriieur!");
                            request.getRequestDispatcher(VUE_LOCATION).forward(request, response);
                        }
                        if (dd.compareTo(df) == 0 || dd.compareTo(df) == 1) {
                            listsd = voitureFacadeLocal.availables(1);
                            if (listsd.isEmpty()) {
                                vide = true;
                            } else {
                                vide = false;
                            }
                            request.setAttribute("vide", vide);
                            request.setAttribute("voitures", listsd);
                            request.setAttribute("l", l);
                            request.setAttribute("e", "Erreur!, incorrect date de location, vérifier la date debut et date fin!");
                            request.getRequestDispatcher(VUE_LOCATION).forward(request, response);
                        } else {

                            //le nombre d'heure autoriser
                            String nbdd = ddt.substring(11, 13);
                            String nbdf = dtf.substring(11, 13);
                            int nbHdd = Integer.parseInt(nbdd);
                            int nbHdf = Integer.parseInt(nbdf);
                            System.out.println(nbHdd + "  " + nbHdf);
                            int nbh = nbHdf - nbHdd;
                            l.setMontant(mnt * nbh);
                            if (nbh < 6 || nbh >= 0) {
                                listsd = voitureFacadeLocal.availables(1);
                                if (listsd.isEmpty()) {
                                    vide = true;
                                } else {
                                    vide = false;
                                }
                                request.setAttribute("vide", vide);
                                request.setAttribute("voitures", listsd);
                                request.setAttribute("l", l);
                                request.setAttribute("errors", "Impossible d'effectuer l'operation:), depassement des heures autorisées. ");
                                request.getRequestDispatcher(VUE_LOCATION).forward(request, response);
                            } else {
                                locationFacadeLocal.create(l);
                                //change statut voiture
                                v.setStatutretour(0);
                                voitureFacadeLocal.edit(v);
                                //retour voiture prevu
                                rv = new Retourvoiture();
                                rv.setIdLocation(l);
                                rv.setDateretour(df);
                                retourvoitureFacadeLocal.create(rv);
                                p = new Penalisation();
                                p.setIdLocation(l);
                                p.setCout(0.0);
                                p.setNbh(nbh);
                                p.setRaison("indefined");
                                penalisationFacadeLocal.create(p);
                                response.sendRedirect(request.getContextPath() + "/location?action=dashboard");
                            }
                        }
                    }
                 }
                    break;
                case "saveclient":
                     session=request.getSession();        
                 if(session.getAttribute("user") == null){
                     response.sendRedirect(request.getContextPath()+"/location?action=login"); 
                 }else
                 {
                     
                    if (request.getParameter("nom").equals("") && request.getParameter("prenom").equals("")
                            && request.getParameter("telephone").equals("") && request.getParameter("adresse").equals("")
                            && request.getParameter("genre").equals("")) {
                        response.sendRedirect(request.getContextPath() + "/location?action=client");
                    } else {
                        client = new Client();
                    }
                    
                     client = clientFacadeLocal.findClientByMatricule(request.getParameter("matricule"));
                     
                    client.setNom(request.getParameter("nom"));
                    client.setGenre(request.getParameter("genre"));
                    client.setPrenom(request.getParameter("prenom"));
                    client.setMatricule(request.getParameter("matricule"));
                    client.setTelephone(request.getParameter("telephone"));
                    client.setAddresse(request.getParameter("adresse"));
                    client.setNidn(request.getParameter("nidn"));
                    client.setPhoto("default.png");
                    
                    
                    clientFacadeLocal.create(client);
                    response.sendRedirect(request.getContextPath() + "/location?action=dashboard");
                     
                   
                 }
                    break;

                case "findClient":
                    param = request.getParameter("param");
                    Client c = clientFacadeLocal.findClientByMatricule(param);
                    //mapper1 = new ObjectMapper();
                    if (c != null) {
                      //  String data = mapper1.writeValueAsString(c);
                      //  response.getWriter().println(data);
                    } else {
                       // String data = mapper1.writeValueAsString(new Client(0));
                      //  response.getWriter().println(data);
                    }
                    break;
                case "findLocation":
                    String par = request.getParameter("param");
                    l = locationFacadeLocal.find(Integer.parseInt(par));
                    //ObjectMapper mapper1 = new ObjectMapper();
                    if (l != null) {
                       // String data = mapper1.writeValueAsString(l);
                       // response.getWriter().println(data);
                    } else {
                        //String data = mapper1.writeValueAsString(new Location(0));
                        ///response.getWriter().println(data);
                    }
                    break;
                    case "findModeleByMarque":
                     param = request.getParameter("param");
                     type  = facadeLocal.find(Integer.parseInt(param));                     
                     Collection<Soustype> listeS= type.getSoustypeCollection();
                    // mapper1 = new ObjectMapper();
                    if (listeS!= null) {
                     //   String data = mapper1.writeValueAsString(listeS);
                       // response.getWriter().println(data);
                    } else {
                       // String data = mapper1.writeValueAsString(type.getSoustypeCollection());
                     //   response.getWriter().println(data);
                    }
                    break;
                case "findVoiture":
                    param = request.getParameter("param");
                    v = voitureFacadeLocal.find(Integer.parseInt(param));
                  //  mapper1 = new ObjectMapper();
                    if (v != null) {
                    //    String data = mapper1.writeValueAsString(v);
                      //  response.getWriter().println(data);
                    } else {
                     //   String data = mapper1.writeValueAsString(new Voiture(0));
                       // response.getWriter().println(data);
                    }
                    break;
                default:
                    response.sendError(404, "la page consulte n'existe pas");
                    break;
            }
        } else {
            response.sendError(404, "la page consulte n'existe pas");
        }
    }

    private static String genkeytoMe(int length) {
        String randomNum = "";
        try {
            SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
            randomNum = new Integer(prng.nextInt()).toString().substring(0, length);
        } catch (NoSuchAlgorithmException e) {

            System.out.println("Une erreur est servenu :  " + e.getMessage());
        }
        return "N" + randomNum;
    }

    public Date parseDate(String date) {
        Date MyDate = null;
        try {
            System.out.println(date);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            MyDate = df.parse(date);
            return Timestamp.valueOf(df.format(MyDate).replace("T", " "));

            //return MyDate;
        } catch (Exception ex) {
            System.out.println("Une erreur est servenu :  " + ex.getMessage());
        }
        return MyDate;
    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /**
         * *** Set Refresh - AutoLoad Time as 15 Seconds ****
         */
        response.setIntHeader("Refresh", 15);    
        List<Penalisation> Lp = penalisationFacadeLocal.findAll();
        List<Retourvoiture> retours = retourvoitureFacadeLocal.isLocation();
        for (Retourvoiture r : retours) {
            for (Penalisation p : Lp) {
                if (p.getNbh() > 0 && p.getIdLocation().equals(r.getIdLocation())) {
                    p.setNbh(p.getNbh() - 1);
                    p.setRaison("En regle");
                    penalisationFacadeLocal.edit(p);
                }

                if (p.getNbh() == 0 || p.getIdLocation().equals(r.getIdLocation())) {
                    p.setNbh(p.getNbhSup() + 1);
                    if (p.getNbhSup() > 0 && p.getNbhSup() < 11) {
                        p.setRaison("Depassement: ");
                        p.setNbhSup(p.getNbhSup() + 1);
                        p.setCout(p.getCout() + 100);
                        penalisationFacadeLocal.edit(p);

                    }
                }
            }
        }
    }
}
