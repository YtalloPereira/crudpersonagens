package br.edu.ifpb.dac.crudpersonagens.business.service;

import java.util.List;

import br.edu.ifpb.dac.crudpersonagens.model.entity.Entry;

public interface EntryService {

	public Entry save(Entry entry);
	
	public Entry update(Entry entry);
	
	public void delete(Long id);
	
	public Entry findById(Long id);
	
	public Iterable<Entry> findAll();

	public List<Entry> find(Entry filter);
}
