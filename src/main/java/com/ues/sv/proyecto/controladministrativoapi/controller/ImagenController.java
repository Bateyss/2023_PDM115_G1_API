package com.ues.sv.proyecto.controladministrativoapi.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ues.sv.proyecto.controladministrativoapi.controller.abs.AbstractController;
import com.ues.sv.proyecto.controladministrativoapi.controller.abs.ErrorResponse;
import com.ues.sv.proyecto.controladministrativoapi.models.Imagen;
import com.ues.sv.proyecto.controladministrativoapi.repository.ImagenRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.ImagenService;

@Controller
@RequestMapping("/imagen")
public class ImagenController extends AbstractController<Imagen, Long, ImagenRepo, ImagenService> {

	@Autowired
	private ImagenService service;

	@Value("${imagenes-folder}")
	private String globarFileLocation;

	@Override
	protected ImagenService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/download/{nombre}")
	public ResponseEntity<?> descargarImagen(@PathVariable(name = "nombre") String nombre) {
		try {
			if (Strings.isNotBlank(nombre)) {
				Path root = Paths.get(globarFileLocation);
				Path path = root.resolve(nombre);
				Resource file;
				file = new UrlResource(path.toUri());
				if (file.exists() && file.isReadable()) {
					return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
							"attachment; filename=\"" + file.getFilename() + "\"").body(file);
				} else {
					return new ResponseEntity<ErrorResponse>(
							new ErrorResponse("01", "imagen no existe o no es utilizable"), HttpStatus.FORBIDDEN);
				}

			} else {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "imagen no existe"),
						HttpStatus.FORBIDDEN);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "Error al buscar imagen", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		try {
			Imagen imagen = new Imagen();
			imagen.setIdImagen(id);
			imagen = service.buscarEntidadPorId(imagen);
			if (imagen != null) {
				return new ResponseEntity<Imagen>(imagen, HttpStatus.OK);
			} else {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "imagen no existe"),
						HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "Error al buscar imagen", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestParam("file") MultipartFile file) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_sss");
			String OriginalName = file.getOriginalFilename();
			String fileName = OriginalName;
			try {
				String fileExtension = OriginalName.substring(OriginalName.lastIndexOf("."));
				fileName = dateFormat.format(new Date()).concat("_IMAGEN").concat(fileExtension);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Imagen imagen = new Imagen();
			imagen.setNombre(fileName);
			imagen.setUbicacion(globarFileLocation + fileName);
			file.transferTo(new File(imagen.getUbicacion()));
			return super.crearEntidad(imagen);
		} catch (Exception e) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "Error al crear imagen", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@PathVariable(name = "id") Long id, @RequestParam("file") MultipartFile file) {
		try {
			Imagen imagen = new Imagen();
			imagen.setIdImagen(id);
			imagen = service.buscarEntidadPorId(imagen);
			if (imagen != null) {
				// eliminar archivo anterior
				Path root = Paths.get(globarFileLocation);
				Path path = root.resolve(imagen.getNombre());
				Files.deleteIfExists(path);
				// crear archivo nuevo
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_sss");
				String OriginalName = file.getOriginalFilename();
				String fileName = OriginalName;
				try {
					String fileExtension = OriginalName.substring(OriginalName.lastIndexOf("."));
					fileName = dateFormat.format(new Date()).concat("_IMAGEN").concat(fileExtension);
				} catch (Exception e) {
					e.printStackTrace();
				}
				imagen.setNombre(fileName);
				imagen.setUbicacion(globarFileLocation + fileName);
				file.transferTo(new File(imagen.getUbicacion()));
				return super.editarEntidad(imagen);
			} else {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "imagen no existe"),
						HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "Error al editar imagen", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		try {
			Imagen imagen = new Imagen();
			imagen.setIdImagen(id);
			imagen = service.buscarEntidadPorId(imagen);
			if (imagen != null) {
				// eliminar archivo anterior
				Path root = Paths.get(globarFileLocation);
				Path path = root.resolve(imagen.getNombre());
				Files.deleteIfExists(path);
				return super.eliminarEntidad(imagen);
			} else {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "imagen no existe"),
						HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			return new ResponseEntity<ErrorResponse>(
					new ErrorResponse("01", "Error al eliminar imagen", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
