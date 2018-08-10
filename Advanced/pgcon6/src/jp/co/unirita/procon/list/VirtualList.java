package jp.co.unirita.procon.list;

import java.util.List;

public interface VirtualList<T> {
	
	// ���X�g�S�̂̃T�C�Y��Ԃ�
	public long size();
	
	// ���X�g�̒��Œl���܂܂�Ă��鐔��Ԃ�
	public long count();
	
	// �w�肳�ꂽ�Y�����ŃA�N�Z�X�����l��Ԃ�
	public T get(long idx);
	
	// �w�肳�ꂽ�͈͂̒l��z��ŕԂ�
	public List<T> get(long startIdx, long endIdx);
	
	// �w�肳�ꂽ�ʒu�ɒl���Z�b�g����
	public void add(long idx, T value);
	
	// �w�肳�ꂽ�͈͂ɒl���Z�b�g����
	public void add(long startIdx, long endIdx, T value);
	
	// �w�肳�ꂽ�Y�����ŃA�N�Z�X�����l���폜����
	public void remove(long idx);
	
	// �w�肳�ꂽ�͈͂̓Y�����ŃA�N�Z�X�����l���폜����
	public void remove(long startIdx, long endIdx);
}