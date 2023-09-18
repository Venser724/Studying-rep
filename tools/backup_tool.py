import os
import shutil
source_path = 'C:/Users/Venser/Desktop/Работа/Новое/Фоспренил 50/'
#print(os.listdir(source_path))
dest_path = 'C:/Users/Venser/Desktop/123/copy_test'
shutil.copytree(source_path, dest_path)
print('Complete')